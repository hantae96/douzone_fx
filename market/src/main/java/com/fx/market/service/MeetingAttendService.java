package com.fx.market.service;

import java.util.List;

import com.fx.market.common.CommonService;
import com.fx.market.common.Viewer;
import com.fx.market.dao.MeetingAttendDao;
import com.fx.market.dto.MeetingAttendDto;

import javafx.scene.control.Alert.AlertType;

public class MeetingAttendService {
	
	private MeetingAttendDao meetingAttendDao; 
	

	public MeetingAttendService() {
		meetingAttendDao = new MeetingAttendDao();
	}

	public void attendMeeting(MeetingAttendDto meetingAttendDto) {
		
		int result = meetingAttendDao.insertAttendMeeting(meetingAttendDto);
		
		if(result != 0) {
			CommonService.msg(AlertType.INFORMATION, "모임 참여", "모임에 참여했습니다.", "");
		}
		
		Viewer.setView("meetingBoardDetailForm");
		
	}

	public List<MeetingAttendDto> getMeetingAttendList(String boardId) {
		
		return meetingAttendDao.selectMeetingAttendList(boardId);
	}



}
