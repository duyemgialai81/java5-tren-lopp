package vn.fpoly.java5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "san_pham")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ma;
    private String ten;
    private String mota;
    private String website;
    @Column(name = "gia_ban")
    private BigDecimal giaBan;
    @Column(name = "so_luong")
    private Integer soLuong;
    @ManyToOne
    @JoinColumn(name = "id_loai_sp", referencedColumnName = "id")
    private Category category;
    @Column(name = "trang_thai")
    private Integer trangThai;
    public String setTingtrangThai(){
        if (this.trangThai == 0){
            return "Còn Hàng";
        } else if (this.trangThai ==1) {
            return "Hết hàng";
        }else {
            return "Đang nhập";
        }
    }
}
