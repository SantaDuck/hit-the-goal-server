package kr.santaduck.hitthegoal.dto;

import java.util.Date;

public class Approval {
	private Integer penaltyId;
	private Integer memberId;
	private Date createDate;
	
	public Integer getPenaltyId() {
		return penaltyId;
	}
	public void setPenaltyId(Integer penaltyId) {
		this.penaltyId = penaltyId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
