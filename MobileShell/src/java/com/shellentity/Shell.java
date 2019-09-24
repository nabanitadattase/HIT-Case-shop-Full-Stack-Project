/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shellentity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nabanita
 */
//Entity class of SHELL table where attribute of SHELL table's getter and setter metod are declared
@Entity
@Table(name = "SHELL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shell.findAll", query = "SELECT s FROM Shell s"),
    @NamedQuery(name = "Shell.findByModel", query = "SELECT s FROM Shell s WHERE s.model = :model"),
    @NamedQuery(name = "Shell.findByBrand", query = "SELECT s FROM Shell s WHERE s.brand = :brand"),
    @NamedQuery(name = "Shell.findByManufacturer", query = "SELECT s FROM Shell s WHERE s.manufacturer = :manufacturer"),
    @NamedQuery(name = "Shell.findByColor", query = "SELECT s FROM Shell s WHERE s.color = :color")})
public class Shell implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MODEL")
    private String model;
    @Size(max = 15)
    @Column(name = "BRAND")
    private String brand;
    @Size(max = 15)
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Size(max = 10)
    @Column(name = "COLOR")
    private String color;

    public Shell() {
    }

    public Shell(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (model != null ? model.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shell)) {
            return false;
        }
        Shell other = (Shell) object;
        if ((this.model == null && other.model != null) || (this.model != null && !this.model.equals(other.model))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shellentity.Shell[ model=" + model + " ]";
    }
    
}
