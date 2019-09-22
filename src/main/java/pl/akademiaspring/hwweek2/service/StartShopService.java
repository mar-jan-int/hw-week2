package pl.akademiaspring.hwweek2.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("START")
public class StartShopService implements Shop {
}
