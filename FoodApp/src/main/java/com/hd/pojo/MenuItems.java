/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hd.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Duong Hoang
 */
@Entity
@Table(name = "menu_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuItems.findAll", query = "SELECT m FROM MenuItems m"),
    @NamedQuery(name = "MenuItems.findById", query = "SELECT m FROM MenuItems m WHERE m.id = :id"),
    @NamedQuery(name = "MenuItems.findByName", query = "SELECT m FROM MenuItems m WHERE m.name = :name"),
    @NamedQuery(name = "MenuItems.findByPrice", query = "SELECT m FROM MenuItems m WHERE m.price = :price"),
    @NamedQuery(name = "MenuItems.findByActive", query = "SELECT m FROM MenuItems m WHERE m.active = :active")})
public class MenuItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{item.name.null}")
    @Size(min = 1, max = 100, message = "{item.name.length}")
    @Column(name = "name")
    private String name;
    @NotNull(message = "{item.price.null}")
    @Column(name = "price")
    private Long price;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne
    private Menu menuId;
    @OneToMany(mappedBy = "itemId", cascade =  CascadeType.ALL)
    private Set<OrderItems> orderItemsSet;

    public MenuItems() {
    }

    public MenuItems(Integer id) {
        this.id = id;
    }

    public MenuItems(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    @XmlTransient
    public Set<OrderItems> getOrderItemsSet() {
        return orderItemsSet;
    }

    public void setOrderItemsSet(Set<OrderItems> orderItemsSet) {
        this.orderItemsSet = orderItemsSet;
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
        if (!(object instanceof MenuItems)) {
            return false;
        }
        MenuItems other = (MenuItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hd.pojo.MenuItems[ id=" + id + " ]";
    }
    
}
