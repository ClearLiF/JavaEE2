package action.goodAction;

import com.opensymphony.xwork2.ActionSupport;
import model.TbShangpin;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.goods.IInsertOrUpdateService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Controller
public class addGoodAction extends ActionSupport {
    private int id;
    private String mingcheng;
    private String jianjie;
    private String addtime;
    private String dengji;
    private String xinghao;

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

    private IInsertOrUpdateService service;
    @Autowired
    public void setService(IInsertOrUpdateService service) {
        this.service = service;
    }

    private TbShangpin tbShangPin;
    @Autowired
    public void setTbShangPin(TbShangpin tbShangPin) {
        this.tbShangPin = tbShangPin;
    }

    private File file;
    //文件类型
    private String fileContentType;
    //文件名称
    private  String fileFileName;

    @Override
    public String execute() throws Exception {
        String path = ServletActionContext.getServletContext().getRealPath("/upload");
        //上传文件类型和上传文件地址
        System.out.println(path);

        System.out.println(fileFileName);
        System.out.println(file.getName());
        File dest = new File(path, fileFileName);
        //完成文件上传
        try {
            FileUtils.copyFile(file,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        tbShangPin.setTupian(fileFileName);
        tbShangPin.setMingcheng(mingcheng);
        tbShangPin.setJianjie(jianjie);
        tbShangPin.setDengji(dengji);
        tbShangPin.setXinghao(xinghao);
        tbShangPin.setPinpai(pinpai);
        tbShangPin.setShuliang(shuliang);
        tbShangPin.setShichangjia(shichangjia);
        tbShangPin.setHuiyuanjia(huiyuanjia);
        tbShangPin.setTejia(tejia);
        tbShangPin.setTuijian(tuijian);
        tbShangPin.setTypeid(typeid);
        tbShangPin.setType2Id(type2Id);
        //下面是新增自动生成的商品资料，如日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date());
        tbShangPin.setAddtime(time);
        service.insertOrUpdate(tbShangPin);
        return SUCCESS;





    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMingcheng() {
        return mingcheng;
    }

    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getDengji() {
        return dengji;
    }

    public void setDengji(String dengji) {
        this.dengji = dengji;
    }

    public String getXinghao() {
        return xinghao;
    }

    public void setXinghao(String xinghao) {
        this.xinghao = xinghao;
    }



    public int getShuliang() {
        return shuliang;
    }

    public void setShuliang(int shuliang) {
        this.shuliang = shuliang;
    }

    public int getCishu() {
        return cishu;
    }

    public void setCishu(int cishu) {
        this.cishu = cishu;
    }

    public int getTuijian() {
        return tuijian;
    }

    public void setTuijian(int tuijian) {
        this.tuijian = tuijian;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public Integer getType2Id() {
        return type2Id;
    }

    public void setType2Id(Integer type2Id) {
        this.type2Id = type2Id;
    }



    public String getHuiyuanjia() {
        return huiyuanjia;
    }

    public void setHuiyuanjia(String huiyuanjia) {
        this.huiyuanjia = huiyuanjia;
    }

    public String getShichangjia() {
        return shichangjia;
    }

    public void setShichangjia(String shichangjia) {
        this.shichangjia = shichangjia;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    public int getTejia() {
        return tejia;
    }

    public void setTejia(int tejia) {
        this.tejia = tejia;
    }
}
