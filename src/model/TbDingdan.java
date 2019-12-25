package model;

import javax.persistence.*;
import java.util.Objects;

/*
 *   #auther:李琪
 *   #date: 2019/12/25
 *   #description
 */
@Entity
@Table(name = "tb_dingdan", schema = "db_tb", catalog = "")
public class TbDingdan {
    private int id;
    private String dingdanhao;
    private String shouhuoren;
    private String sex;
    private String dizhi;
    private String youbian;
    private String tel;
    private String shsj;
    private String zffs;
    private String leaveword;
    private String time;
    private String xiadanren;
    private String zt;
    private String total;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dingdanhao")
    public String getDingdanhao() {
        return dingdanhao;
    }

    public void setDingdanhao(String dingdanhao) {
        this.dingdanhao = dingdanhao;
    }

    @Basic
    @Column(name = "shouhuoren")
    public String getShouhuoren() {
        return shouhuoren;
    }

    public void setShouhuoren(String shouhuoren) {
        this.shouhuoren = shouhuoren;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "dizhi")
    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    @Basic
    @Column(name = "youbian")
    public String getYoubian() {
        return youbian;
    }

    public void setYoubian(String youbian) {
        this.youbian = youbian;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "shsj")
    public String getShsj() {
        return shsj;
    }

    public void setShsj(String shsj) {
        this.shsj = shsj;
    }

    @Basic
    @Column(name = "zffs")
    public String getZffs() {
        return zffs;
    }

    public void setZffs(String zffs) {
        this.zffs = zffs;
    }

    @Basic
    @Column(name = "leaveword")
    public String getLeaveword() {
        return leaveword;
    }

    public void setLeaveword(String leaveword) {
        this.leaveword = leaveword;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "xiadanren")
    public String getXiadanren() {
        return xiadanren;
    }

    public void setXiadanren(String xiadanren) {
        this.xiadanren = xiadanren;
    }

    @Basic
    @Column(name = "zt")
    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    @Basic
    @Column(name = "total")
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbDingdan tbDingdan = (TbDingdan) o;
        return id == tbDingdan.id &&
                Objects.equals(dingdanhao, tbDingdan.dingdanhao) &&
                Objects.equals(shouhuoren, tbDingdan.shouhuoren) &&
                Objects.equals(sex, tbDingdan.sex) &&
                Objects.equals(dizhi, tbDingdan.dizhi) &&
                Objects.equals(youbian, tbDingdan.youbian) &&
                Objects.equals(tel, tbDingdan.tel) &&
                Objects.equals(shsj, tbDingdan.shsj) &&
                Objects.equals(zffs, tbDingdan.zffs) &&
                Objects.equals(leaveword, tbDingdan.leaveword) &&
                Objects.equals(time, tbDingdan.time) &&
                Objects.equals(xiadanren, tbDingdan.xiadanren) &&
                Objects.equals(zt, tbDingdan.zt) &&
                Objects.equals(total, tbDingdan.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dingdanhao, shouhuoren, sex, dizhi, youbian, tel, shsj, zffs, leaveword, time, xiadanren, zt, total);
    }
}
