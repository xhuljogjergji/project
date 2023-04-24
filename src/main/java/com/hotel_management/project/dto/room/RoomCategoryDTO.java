package com.hotel_management.project.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomCategoryDTO {
    private Integer id;
    private String name;
    private RoomCategoryDTO parentCategory;
}
