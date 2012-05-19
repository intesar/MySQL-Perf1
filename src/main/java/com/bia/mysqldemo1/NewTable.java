/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.mysqldemo1;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "new_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewTable.findAll", query = "SELECT n FROM NewTable n"),
    @NamedQuery(name = "NewTable.findById", query = "SELECT n FROM NewTable n WHERE n.id = :id"),
    @NamedQuery(name = "NewTable.findByName", query = "SELECT n FROM NewTable n WHERE n.name = :name"),
    @NamedQuery(name = "NewTable.findByEmail", query = "SELECT n FROM NewTable n WHERE n.email = :email")})
public class NewTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public NewTable() {
    }

    public NewTable(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    
    public NewTable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof NewTable)) {
            return false;
        }
        NewTable other = (NewTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.mysqldemo1.NewTable[ id=" + id + " ]";
    }
    
}
