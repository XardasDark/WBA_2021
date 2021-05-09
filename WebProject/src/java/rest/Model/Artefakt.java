/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author TimoK
 */
@Entity
@Table(name="Artefakt")
@NamedQuery(name="Artefakt.findByTitel",query="SELECT k FROM Artefakt k WHERE k.titel= :titel")
public class Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "titel")
    private String titel;
    @Column(name = "beschreibung")
    private String beschreibung;
    
    @ManyToOne
    @JoinColumn(name="aufgabenbereich_id",nullable=false)
    private Aufgabenbereich aufgabenbereich;
    
    @OneToMany(mappedBy="artefakt")
    private Collection<Artefakt_Projekt_Zeit> artefakt_projekt_zeit;

    public Long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Aufgabenbereich getAufgabenbereich() {
        return aufgabenbereich;
    }

    public Collection<Artefakt_Projekt_Zeit> getArtefakt_projekt_zeit() {
        return artefakt_projekt_zeit;
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
        if (!(object instanceof Artefakt)) {
            return false;
        }
        Artefakt other = (Artefakt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Model.Artefakt[ id=" + id + " ]";
    }
    
}
