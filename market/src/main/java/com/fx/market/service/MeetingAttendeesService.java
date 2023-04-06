package com.fx.market.service;

import java.util.List;

import com.fx.market.common.CommonService;
import com.fx.market.common.Viewer;
import com.fx.market.dao.MeetingAttendeesDao;
import com.fx.market.dto.MeetingAttendeesDto;

import javafx.scene.control.Alert.AlertType;

public class MeetingAttendeesService {
	
	private MeetingAttendeesDao meetingAttendDao; 
	

	public MeetingAttendeesService() {
		meetingAttendDao = new MeetingAttendeesDao();
	}

	public void attendMeeting(MeetingAttendeesDto meetingAttendDto) {
		
		int result = meetingAttendDao.insertAttendMeeting(meetingAttendDto);
		
		if(result != 0) {
			CommonService.msg(AlertType.INFORMATION, "모임 참여", "모임에 참여했습니다.", "");
		}
		
		Viewer.setView("meetingBoardDetailForm");
		
	}

	public List<MeetingAttendeesDto> getMeetingAttendList(String boardId) {
		
		return meetingAttendDao.selectMeetingAttendList(boardId);
	}



}
