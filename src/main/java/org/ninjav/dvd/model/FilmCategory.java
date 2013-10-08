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
@javax.persistence.IdClass(org.ninjav.dvd.model.FilmCategoryPK.class)
@javax.persistence.Table(name = "film_category", schema = "public", catalog = "dvdrental")
@Entity
public class FilmCategory {
    private short filmId;
    private short categoryId;

    @Id
    @Column(name = "film_id", nullable = false, insertable = false, updatable = false, length = 5, precision = 0)
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Id
    @Column(name = "category_id", nullable = false, insertable = false, updatable = false, length = 5, precision = 0)
    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
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

        FilmCategory that = (FilmCategory) o;

        if (!categoryByCategoryId.equals(((FilmCategory) o).getCategoryByCategoryId())) return false;
        if (!filmByFilmId.equals(((FilmCategory) o).getFilmByFilmId())) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmByFilmId.hashCode();
        result = 31 * result + categoryByCategoryId.hashCode();
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    private Category categoryByCategoryId;

    @Id
    @ManyToOne
    @javax.persistence.JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
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
