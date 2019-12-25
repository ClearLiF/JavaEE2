package model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Entity
@Table(name = "tb_shangpin", schema = "db_tb", catalog = "")
public class TbShangpin {
    private int id;
    private String mingcheng;
    private String jianjie;
    private String addtime;
    private String dengji;
    private String xinghao;
    private String tupian;
    private int shuliang;
    private int cishu;
    private int tuijian;
    private int typeid;
    private Integer type2Id;
    private Integer type3Id;
    private String huiyuanjia;
    private String shichangjia;
    private String pinpai;
    private int tejia;
    private Set<TbPinglun> tbPingluns;

    public Set<TbPinglun> getTbPingluns() {
        return tbPingluns;
    }

    public void setTbPingluns(Set<TbPinglun> tbPingluns) {
        this.tbPingluns = tbPingluns;
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
    @Column(name = "mingcheng")
    public String getMingcheng() {
        return mingcheng;
    }

    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

    @Basic
    @Column(name = "jianjie")
    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    @Basic
    @Column(name = "addtime")
    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    @Basic
    @Column(name = "dengji")
    public String getDengji() {
        return dengji;
    }

    public void setDengji(String dengji) {
        this.dengji = dengji;
    }

    @Basic
    @Column(name = "xinghao")
    public String getXinghao() {
        return xinghao;
    }

    public void setXinghao(String xinghao) {
        this.xinghao = xinghao;
    }

    @Basic
    @Column(name = "tupian")
    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    @Basic
    @Column(name = "shuliang")
    public int getShuliang() {
        return shuliang;
    }

    public void setShuliang(int shuliang) {
        this.shuliang = shuliang;
    }

    @Basic
    @Column(name = "cishu")
    public int getCishu() {
        return cishu;
    }

    public void setCishu(int cishu) {
        this.cishu = cishu;
    }

    @Basic
    @Column(name = "tuijian")
    public int getTuijian() {
        return tuijian;
    }

    public void setTuijian(int tuijian) {
        this.tuijian = tuijian;
    }

    @Basic
    @Column(name = "typeid")
    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    @Basic
    @Column(name = "type2id")
    public Integer getType2Id() {
        return type2Id;
    }

    public void setType2Id(Integer type2Id) {
        this.type2Id = type2Id;
    }

    @Basic
    @Column(name = "type3id")
    public Integer getType3Id() {
        return type3Id;
    }

    public void setType3Id(Integer type3Id) {
        this.type3Id = type3Id;
    }

    @Basic
    @Column(name = "huiyuanjia")
    public String getHuiyuanjia() {
        return huiyuanjia;
    }

    public void setHuiyuanjia(String huiyuanjia) {
        this.huiyuanjia = huiyuanjia;
    }

    @Basic
    @Column(name = "shichangjia")
    public String getShichangjia() {
        return shichangjia;
    }

    public void setShichangjia(String shichangjia) {
        this.shichangjia = shichangjia;
    }

    @Basic
    @Column(name = "pinpai")
    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    @Basic
    @Column(name = "tejia")
    public int getTejia() {
        return tejia;
    }

    public void setTejia(int tejia) {
        this.tejia = tejia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbShangpin that = (TbShangpin) o;
        return id == that.id &&
                shuliang == that.shuliang &&
                cishu == that.cishu &&
                tuijian == that.tuijian &&
                typeid == that.typeid &&
                tejia == that.tejia &&
                Objects.equals(mingcheng, that.mingcheng) &&
                Objects.equals(jianjie, that.jianjie) &&
                Objects.equals(addtime, that.addtime) &&
                Objects.equals(dengji, that.dengji) &&
                Objects.equals(xinghao, that.xinghao) &&
                Objects.equals(tupian, that.tupian) &&
                Objects.equals(type2Id, that.type2Id) &&
                Objects.equals(type3Id, that.type3Id) &&
                Objects.equals(huiyuanjia, that.huiyuanjia) &&
                Objects.equals(shichangjia, that.shichangjia) &&
                Objects.equals(pinpai, that.pinpai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mingcheng, jianjie, addtime, dengji, xinghao, tupian, shuliang, cishu, tuijian, typeid, type2Id, type3Id, huiyuanjia, shichangjia, pinpai, tejia);
    }

    @Override
    public String toString() {
        return "TbShangpin{" +
                "id=" + id +
                ", mingcheng='" + mingcheng + '\'' +
                ", jianjie='" + jianjie + '\'' +
                ", addtime='" + addtime + '\'' +
                ", dengji='" + dengji + '\'' +
                ", xinghao='" + xinghao + '\'' +
                ", tupian='" + tupian + '\'' +
                ", shuliang=" + shuliang +
                ", cishu=" + cishu +
                ", tuijian=" + tuijian +
                ", typeid=" + typeid +
                ", type2Id=" + type2Id +
                ", type3Id=" + type3Id +
                ", huiyuanjia='" + huiyuanjia + '\'' +
                ", shichangjia='" + shichangjia + '\'' +
                ", pinpai='" + pinpai + '\'' +
                ", tejia=" + tejia +
                '}';
    }
}
