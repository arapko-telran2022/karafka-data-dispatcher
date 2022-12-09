package telran.java2022.karafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PulseDto {
	int id;
	long timestamp;
	int data;

}