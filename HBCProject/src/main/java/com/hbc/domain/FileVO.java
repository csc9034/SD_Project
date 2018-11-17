package com.hbc.domain;

import java.util.Arrays;
import java.util.Date;

/*CREATE TABLE TBL_ATTACH
(
	FILENAME             CHAR(18) NOT NULL -- 파일명
  , REGDATE              CHAR(18) DEFAULT SYSDATE NOT NULL -- 등록일
  , NONUM                NUMBER NULL -- 공지사항 글번호
  , REVIEWNUM            NUMBER NULL -- 수강후기 글번호
  , NEWSNUM              NUMBER NULL -- 기사 글번호
  , CONSTRAINT PK_TBL_ATTACH_FILENAME PRIMARY KEY (FILENAME)
  , CONSTRAINT FK_TBL_ATTACH_NONUM FOREIGN KEY (NONUM)
                                    REFERENCES TBL_NOTICE (NONUM)
  , CONSTRAINT FK_TBL_ATTACH_REVIEWNUM FOREIGN KEY (REVIEWNUM)
                                    REFERENCES TBL_COURREVIEW (REVIEWNUM)
  , CONSTRAINT FK_TBL_ATTACH_NEWSNUM FOREIGN KEY (NEWSNUM)
                                    REFERENCES TBL_NEWS (NEWSNUM)
)
;
*/
public class FileVO {

	private String fileName;
	
	private Date fileRegDate;
	
	private int noNum;
	
	private int reviewNum;
	
	private int newsNum;
	
	private String[] files;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getFileRegDate() {
		return fileRegDate;
	}

	public void setFileRegDate(Date fileRegDate) {
		this.fileRegDate = fileRegDate;
	}

	public int getNoNum() {
		return noNum;
	}

	public void setNoNum(int noNum) {
		this.noNum = noNum;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public int getNewsNum() {
		return newsNum;
	}

	public void setNewsNum(int newsNum) {
		this.newsNum = newsNum;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "FileVO [fileName=" + fileName + ", fileRegDate=" + fileRegDate + ", noNum=" + noNum + ", reviewNum="
				+ reviewNum + ", newsNum=" + newsNum + ", files=" + Arrays.toString(files) + "]";
	}

	
	
	
	
	
}
