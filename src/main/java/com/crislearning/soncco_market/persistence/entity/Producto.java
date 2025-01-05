package com.crislearning.soncco_market.persistence.entity;

import java.util.List;

import org.hibernate.annotations.Columns;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "PRODUCTOS")
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_PRODUCTO")
    private Integer idProducto;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="ID_CATEGORIA")
    private Integer id_categoria;

    @Column(name="CODIGO_BARRAS")
    private String codigoBarras;

    @Column(name="PRECIO_VENTA")
    private Double precioVenta;

    @Column(name="CANTIDAD_STOCK")
    private Integer cantidadStock;

    @Column(name="ESTADO")
    private Integer estado;

    @ManyToOne
    @JoinColumn(name="id_categoria",insertable = false,updatable=false)
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> ComprasProductos;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
