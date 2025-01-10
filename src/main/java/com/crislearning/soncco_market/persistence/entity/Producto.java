package com.crislearning.soncco_market.persistence.entity;

import java.math.BigDecimal;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Integer idCategoria;

    @Column(name="CODIGO_BARRAS")
    private String codigoBarras;

    @Column(name="PRECIO_VENTA")
    private BigDecimal precioVenta;

    @Column(name="CANTIDAD_STOCK")
    private Integer cantidadStock;

    @Column(name="ESTADO")
    private String estado;

    @ManyToOne
    @JoinColumn(name="id_categoria",insertable = false,updatable=false)
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> comprasProductos;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ComprasProducto> getComprasProductos() {
        return comprasProductos;
    }

    public void setComprasProductos(List<ComprasProducto> comprasProductos) {
        this.comprasProductos = comprasProductos;
    }

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

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public BigDecimal  getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal  precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
