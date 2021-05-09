/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author TimoK
 */
@Entity
@Table(name="Aufgabenbereich")
@NamedQuery(name="Aufgabenbereich.findByTitel",query="SELECT k FROM Aufgabenbereich k WHERE k.titel= :titel")
public class Aufgabenbereich implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "titel")
    private String titel;
    @Column(name = "kurzbeschreibung")
    private String kurzbeschreibung;
    
    @ManyToOne
    @JoinColumn(name="projekt_id",nullable=false)
    private Projekt projekt;
    
    @OneToMany(mappedBy="aufgabenbereich")
    private Collection<Artefakt> artefakt;

    public Long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getKurzbeschreibung() {
        return kurzbeschreibung;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public Collection<Artefakt> getArtefakt() {
        return artefakt;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aufgabenbereich)) {
            return false;
        }
        Aufgabenbereich other = (Aufgabenbereich) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Model.Aufgabenbereich[ id=" + id + " ]";
    }
    
}
