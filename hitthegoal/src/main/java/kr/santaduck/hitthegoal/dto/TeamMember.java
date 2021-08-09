package kr.santaduck.hitthegoal.dto;

import java.util.Date;

public class TeamMember {
	private Integer teamId;
	private Integer memberId;
	private Boolean isKing;
	private Date createDate;
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Boolean getIsKing() {
		return isKing;
	}
	public void setIsKing(Boolean isKing) {
		this.isKing = isKing;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
