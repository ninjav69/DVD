package org.ninjav.dvd.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: apickard
 * Date: 10/7/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Film {
    private int filmId;

    @javax.persistence.Column(name = "film_id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    private String title;

    @javax.persistence.Column(name = "title", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    @javax.persistence.Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private short rentalDuration;

    @javax.persistence.Column(name = "rental_duration", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    private BigDecimal rentalRate;

    @javax.persistence.Column(name = "rental_rate", nullable = false, insertable = true, updatable = true, length = 4, precision = 2)
    @Basic
    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    private Short length;

    @javax.persistence.Column(name = "length", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    private BigDecimal replacementCost;

    @javax.persistence.Column(name = "replacement_cost", nullable = false, insertable = true, updatable = true, length = 5, precision = 2)
    @Basic
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
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

        Film film = (Film) o;

        if (filmId != film.filmId) return false;
        if (rentalDuration != film.rentalDuration) return false;
        if (description != null ? !description.equals(film.description) : film.description != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(film.lastUpdate) : film.lastUpdate != null) return false;
        if (length != null ? !length.equals(film.length) : film.length != null) return false;
        if (rentalRate != null ? !rentalRate.equals(film.rentalRate) : film.rentalRate != null) return false;
        if (replacementCost != null ? !replacementCost.equals(film.replacementCost) : film.replacementCost != null)
            return false;
        if (title != null ? !title.equals(film.title) : film.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) rentalDuration;
        result = 31 * result + (rentalRate != null ? rentalRate.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (replacementCost != null ? replacementCost.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    private Language languageByLanguageId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
    public Language getLanguageByLanguageId() {
        return languageByLanguageId;
    }

    public void setLanguageByLanguageId(Language languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }

    private Collection<FilmActor> filmActorsByFilmId;

    @OneToMany(mappedBy = "filmByFilmId")
    public Collection<FilmActor> getFilmActorsByFilmId() {
        return filmActorsByFilmId;
    }

    public void setFilmActorsByFilmId(Collection<FilmActor> filmActorsByFilmId) {
        this.filmActorsByFilmId = filmActorsByFilmId;
    }

    private Collection<FilmCategory> filmCategoriesByFilmId;

    @OneToMany(mappedBy = "filmByFilmId")
    public Collection<FilmCategory> getFilmCategoriesByFilmId() {
        return filmCategoriesByFilmId;
    }

    public void setFilmCategoriesByFilmId(Collection<FilmCategory> filmCategoriesByFilmId) {
        this.filmCategoriesByFilmId = filmCategoriesByFilmId;
    }

    private Collection<Inventory> inventoriesByFilmId;

    @OneToMany(mappedBy = "filmByFilmId")
    public Collection<Inventory> getInventoriesByFilmId() {
        return inventoriesByFilmId;
    }

    public void setInventoriesByFilmId(Collection<Inventory> inventoriesByFilmId) {
        this.inventoriesByFilmId = inventoriesByFilmId;
    }
}
