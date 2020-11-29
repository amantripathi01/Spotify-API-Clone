package com.csc301.songmicroservice;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SongDalImpl implements SongDal {

	private final MongoTemplate db;

	/**
	 * readability
	 */
	private final DbQueryExecResult OK = DbQueryExecResult.QUERY_OK;
	private final DbQueryExecResult ERR = DbQueryExecResult.QUERY_ERROR_GENERIC;
	private final DbQueryExecResult ERR404 = DbQueryExecResult.QUERY_ERROR_NOT_FOUND;

	@Autowired
	public SongDalImpl(MongoTemplate mongoTemplate) {
		this.db = mongoTemplate;
	}

	@Override
	public DbQueryStatus addSong(Song songToAdd) {
		boolean valid = songToAdd.getSongName() != null && songToAdd.getSongAlbum() != null
				&& songToAdd.getSongArtistFullName() != null;
		Song inserted = valid ? db.insert(songToAdd, "songs") : null;
		DbQueryStatus status = new DbQueryStatus("POST", inserted != null ? this.OK : this.ERR);
		if (inserted != null)
			status.setData(inserted.getJsonRepresentation());
		return status;
	}

	@Override
	public DbQueryStatus findSongById(String songId) {
		Song found = db.findById(new ObjectId(songId), Song.class);
		DbQueryStatus status = new DbQueryStatus("GET", found != null ? this.OK : this.ERR404);
		status.setData(found.getJsonRepresentation());
		return status;
	}

	@Override
	public DbQueryStatus getSongTitleById(String songId) {
		Song found = db.findById(new ObjectId(songId), Song.class);
		DbQueryStatus status = new DbQueryStatus("GET", found != null ? this.OK : this.ERR404);
		if(found != null)
			status.setData(found.getSongName());
		return status;
	}

	@Override
	public DbQueryStatus deleteSongById(String songId) {
		Song found = db.findById(new ObjectId(songId), Song.class);
		DbQueryStatus status = new DbQueryStatus("DELETE", found == null ? this.ERR404 : this.OK);
		if (found != null) {
			db.remove(found, "songs");
		}
		return status;
	}

	@Override
	public DbQueryStatus updateSongFavouritesCount(String songId, boolean shouldDecrement) {
		Song found = db.findById(new ObjectId(songId), Song.class);
		if (found != null) {
			long count = found.getSongAmountFavourites() + (shouldDecrement ? -1 : 1);
			found.setSongAmountFavourites(count);
			found = db.save(found);
		}
		DbQueryStatus status = new DbQueryStatus("PUT", found == null ? this.ERR404 : this.OK);
		return status;
	}
}