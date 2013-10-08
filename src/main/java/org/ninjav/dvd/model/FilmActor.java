package org.ninjav.dvd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: apickard
 * Date: 10/7/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(org.ninjav.dvd.model.FilmActorPK.class)
@javax.persistence.Table(name = "film_actor", schema = "public", catalog = "dvdrental")
@Entity
public class FilmActor {
    private short actorId;
    private short filmId;

    @Id
    @Column(name = "actor_id", nullable = false, insertable = false, updatable = false, length = 5, precision = 0)
    public short getActorId() {
        return actorId;
    }

    @Id
    @Column(name = "film_id", nullable = false, insertable = false, updatable = false, length = 5, precision = 0)
    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    private Timestamp lastUpdate;

    @javax.persistence.Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 29, precision = 6)
    @Basic
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmActor filmActor = (FilmActor) o;

        if (!actorByActorId.equals(((FilmActor) o).getActorByActorId())) return false;
        if (!filmByFilmId.equals(((FilmActor) o).getFilmByFilmId())) return false;
        if (lastUpdate != null ? !lastUpdate.equals(filmActor.lastUpdate) : filmActor.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + actorByActorId.hashCode();
        result = 31 * result + filmByFilmId.hashCode();
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    private Actor actorByActorId;

    @Id
    @ManyToOne
    @javax.persistence.JoinColumn(name = "actor_id", referencedColumnName = "actor_id", nullable = false)
    public Actor getActorByActorId() {
        return actorByActorId;
    }

    public void setActorByActorId(Actor actorByActorId) {
        this.actorByActorId = actorByActorId;
    }

    private Film filmByFilmId;

    @Id
    @ManyToOne
    @javax.persistence.JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    public Film getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(Film filmByFilmId) {
        this.filmByFilmId = filmByFilmId;
    }
}
