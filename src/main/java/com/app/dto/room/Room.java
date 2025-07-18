package com.app.dto.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter	
@Getter //필드에 대한 getter, setter 포함시켜줌
@ToString
@NoArgsConstructor	//매개변수 없이 그냥 만드는 생성자 new Room()
@AllArgsConstructor	//매개변수 모두 넣어서 생성자 만드는... new Room( , , , , ,)
public class Room { //DTO 역할

	int roomId;	  			//PK 기본키 식별자
	String buildingName;	//동 이름 101 A B 301
	int roomNumber;			//호실 번호 1101 2307
	int floor;				//층 수
	int maxGuestCount;		//최대 숙박 인원
	String viewType;		//뷰 구분 코드 (오션뷰OCN 시티뷰CTY 마운틴뷰MOT)

}
