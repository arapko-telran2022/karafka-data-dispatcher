package telran.java2022.karafka.service;

import java.util.function.Consumer;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.karafka.dto.PulseDto;

@Service
@RequiredArgsConstructor
public class DispatcherKarafkaService {
	int min = 40;
	int max = 120;
	
	final StreamBridge streamBridge;

    @Bean
    Consumer<PulseDto> dispatchData() {
        return data -> {
            if (data.getData() < min) {
                streamBridge.send("minPulse-out-0", data);
                return;
            }
            if (data.getData() > max) {
                streamBridge.send("maxPulse-out-0", data);
                return;
            }
            Long delay = System.currentTimeMillis() - data.getTimestamp();
            System.out.println("delay: " + delay + ", id: " + data.getId() + ", pulse: " + data.getData());
        };
    }
}
