/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.Model;

import java.io.Serializable;
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
@Table(name="Artefakt_Projekt_Zeit")
@NamedQuery(name="Artefakt_Projekt_Zeit.findById",query="SELECT k FROM Artefakt_Projekt_Zeit k WHERE k.id= :id")
public class Artefakt_Projekt_Zeit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="arbeitszeit")
    private String arbeitszeit;
    
    
    @ManyToOne
    @JoinColumn(name="artefakt_id",nullable=false)
    private Artefakt artefakt;
    

    public Long getId() {
        return id;
    }

    public String getArbeitszeit() {
        return arbeitszeit;
    }

    public Artefakt getArtefakt() {
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
        if (!(object instanceof Artefakt_Projekt_Zeit)) {
            return false;
        }
        Artefakt_Projekt_Zeit other = (Artefakt_Projekt_Zeit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Model.Artefakt_Projekt_Time[ id=" + id + " ]";
    }
    
}
