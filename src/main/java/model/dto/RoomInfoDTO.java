package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class RoomInfoDTO {

    private String roomID;

    private String type;

    private String description;

    private double price;

}
