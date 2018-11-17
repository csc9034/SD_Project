package com.hbc.domain;

import java.util.Arrays;
import java.util.Date;

public class ImgBoardVO {
   //게시물 번호
   private Integer imgnum;
   
   //게시물제목
   private String title;
   private Date regdate;
   private Date moddate;
   private String content;
   private Integer viewcnt;
   private Integer intronum;
   private String adminId;
   
   /**
    * 파일명
    */
   private String name;
   
   //선택한 기관 정보
   private Integer compnum;
   private String compname;
   
   /**
    * 첨부파일
    */
   //추가 이미지
   private String[] files;
   //메인 이미지 1 장
   private String mainfile;
   
   
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getMainfile() {
      return mainfile;
   }

   public void setMainfile(String mainfile) {
      this.mainfile = mainfile;
   }

   public String[] getFiles() {
      return files;
   }

   public void setFiles(String[] files) {
      this.files = files;
   }

   public Integer getImgnum() {
      return imgnum;
   }

   public void setImgnum(Integer imgnum) {
      this.imgnum = imgnum;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Date getRegdate() {
      return regdate;
   }

   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }

   public Date getModdate() {
      return moddate;
   }

   public void setModdate(Date moddate) {
      this.moddate = moddate;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Integer getViewcnt() {
      return viewcnt;
   }

   public void setViewcnt(Integer viewcnt) {
      this.viewcnt = viewcnt;
   }

   public Integer getIntronum() {
      return intronum;
   }

   public void setIntronum(Integer intronum) {
      this.intronum = intronum;
   }

   public String getadminId() {
      return adminId;
   }

   public void setadminId(String adminId) {
      this.adminId = adminId;
   }
   
   public Integer getCompnum() {
      return compnum;
   }

   public void setCompnum(Integer compnum) {
      this.compnum = compnum;
   }

   public String getCompname() {
      return compname;
   }

   public void setCompname(String compname) {
      this.compname = compname;
   }

   @Override
   public String toString() {
      return "ImgBoardVO [imgnum=" + imgnum + ", title=" + title + ", regdate=" + regdate + ", moddate=" + moddate
            + ", content=" + content + ", viewcnt=" + viewcnt + ", intronum=" + intronum + ", adminId=" + adminId
            + ", name=" + name + ", compnum=" + compnum + ", compname=" + compname + ", files="
            + Arrays.toString(files) + ", mainfile=" + mainfile + "]";
   }

   
   
//   @Override
//   public String toString() {
//      return "ImgBoardVO [imgnum=" + imgnum + ", title=" + title + ", regdate=" + regdate + ", moddate=" + moddate
//            + ", content=" + content + ", viewcnt=" + viewcnt + ", intronum=" + intronum + ", adminId=" + adminId
//            + ", compnum=" + compnum + ", compname=" + compname + ", files=" + Arrays.toString(files)
//            + ", mainfile=" + mainfile + "]";
//   }

   
   
/*   @Override
   public String toString() {
      return "ImgBoardVO [imgnum=" + imgnum + ", title=" + title + ", regdate=" + regdate + ", moddate=" + moddate
            + ", content=" + content + ", viewcnt=" + viewcnt + ", intronum=" + intronum + ", adminId=" + adminId
            + ", files=" + Arrays.toString(files) + ", mainfile=" + mainfile + "]";
   }*/

/*   @Override
   public String toString() {
      return "ImgBoardVO [imgnum=" + imgnum + ", title=" + title + ", regdate=" + regdate + ", moddate=" + moddate
            + ", content=" + content + ", viewcnt=" + viewcnt + ", intronum=" + intronum + ", adminId=" + adminId
            + "]";
   }*/

/*   @Override
   public String toString() {
      return "ImgBoardVO [imgnum=" + imgnum + ", title=" + title + ", regdate=" + regdate + ", moddate=" + moddate
            + ", content=" + content + ", viewcnt=" + viewcnt + ", intronum=" + intronum + ", adminId=" + adminId
            + ", files=" + Arrays.toString(files) + "]";
   }*/

   

}