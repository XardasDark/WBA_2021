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
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TimoK
 */
@Entity
@Table(name = "Projekt")
    @NamedQuery(name="Projekt.findByTitel",query="SELECT k FROM Projekt k WHERE k.titel= :titel")
public class Projekt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "titel")
    private String titel;
    @Column(name = "kurzbeschreibung")
    private String kurzbeschreibung;
    @Column(name = "projektlogo")
    private String projektlogo;
    @Column(name = "projektstart")
    private String projektstart;
   
    @OneToMany(mappedBy="projekt")
    private Collection<Aufgabenbereich> aufgabenbereich;

    public String getTitel() {
        return titel;
    }

    public String getKurzbeschreibung() {
        return kurzbeschreibung;
    }

    public String getProjektlogo() {
        return projektlogo;
    }

    public String getProjektstart() {
        return projektstart;
    }

    public Collection<Aufgabenbereich> getAufgabenbereich() {
        return aufgabenbereich;
    }

    public Long getId() {
        return id;
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
        if (!(object instanceof Projekt)) {
            return false;
        }
        Projekt other = (Projekt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Model.Projekt[ id=" + id + " ]";
    }
    
}
