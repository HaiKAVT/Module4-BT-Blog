package model;

import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String tacGia;
    private String tenBlog;
    private Date date;
    @Column(columnDefinition = "TEXT")
    private  String noiDung;
    private String image;

    public Blog(int id, String tacGia, String tenBlog, Date date, String noiDung, String image) {
        this.id = id;
        this.tacGia = tacGia;
        this.tenBlog = tenBlog;
        this.date = date;
        this.noiDung = noiDung;
        this.image = image;
    }

    public Blog() {
    }

    public Blog(int id, String tacGia, String tenBlog, Date date, String noiDung) {
        this.id = id;
        this.tacGia = tacGia;
        this.tenBlog = tenBlog;
        this.date = date;
        this.noiDung = noiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTenBlog() {
        return tenBlog;
    }

    public void setTenBlog(String tenBlog) {
        this.tenBlog = tenBlog;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
