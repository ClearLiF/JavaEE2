package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
@Entity
@Table(name = "tb_user", schema = "db_tb", catalog = "")
public class User {
    private int id;
    private String name;
    private String pwd;
    private int dongjie;
    private String email;
    private String tel;
    private String qq;
    private String ip;
    private String tishi;
    private String huida;
    private String dizhi;
    private String youbian;
    private String regtime;
    private String lastlogintime;
    private int logincishu;
    private String truename;
    private String pwd1;
    private Set<TbGouwuche> gouwuches = new HashSet<>();

    public Set<TbPinglun> getPingluns() {
        return pingluns;
    }

    public void setPingluns(Set<TbPinglun> pingluns) {
        this.pingluns = pingluns;
    }

    private Set<TbPinglun> pingluns = new HashSet<>();
    public Set<TbGouwuche> getGouwuches() {
        return gouwuches;
    }

    public void setGouwuches(Set<TbGouwuche> gouwuches) {
        this.gouwuches = gouwuches;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "dongjie")
    public int getDongjie() {
        return dongjie;
    }

    public void setDongjie(int dongjie) {
        this.dongjie = dongjie;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "tishi")
    public String getTishi() {
        return tishi;
    }

    public void setTishi(String tishi) {
        this.tishi = tishi;
    }

    @Basic
    @Column(name = "huida")
    public String getHuida() {
        return huida;
    }

    public void setHuida(String huida) {
        this.huida = huida;
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
    @Column(name = "regtime")
    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    @Basic
    @Column(name = "lastlogintime")
    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @Basic
    @Column(name = "logincishu")
    public int getLogincishu() {
        return logincishu;
    }

    public void setLogincishu(int logincishu) {
        this.logincishu = logincishu;
    }

    @Basic
    @Column(name = "truename")
    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    @Basic
    @Column(name = "pwd1")
    public String getPwd1() {
        return pwd1;
    }

    public void setPwd1(String pwd1) {
        this.pwd1 = pwd1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                dongjie == user.dongjie &&
                logincishu == user.logincishu &&
                Objects.equals(name, user.name) &&
                Objects.equals(pwd, user.pwd) &&
                Objects.equals(email, user.email) &&
                Objects.equals(tel, user.tel) &&
                Objects.equals(qq, user.qq) &&
                Objects.equals(ip, user.ip) &&
                Objects.equals(tishi, user.tishi) &&
                Objects.equals(huida, user.huida) &&
                Objects.equals(dizhi, user.dizhi) &&
                Objects.equals(youbian, user.youbian) &&
                Objects.equals(regtime, user.regtime) &&
                Objects.equals(lastlogintime, user.lastlogintime) &&
                Objects.equals(truename, user.truename) &&
                Objects.equals(pwd1, user.pwd1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pwd, dongjie, email, tel, qq, ip, tishi, huida, dizhi, youbian, regtime, lastlogintime, logincishu, truename, pwd1);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", dongjie=" + dongjie +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }
}
