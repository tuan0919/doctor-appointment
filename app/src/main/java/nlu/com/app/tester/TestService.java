package nlu.com.app.tester;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService implements ITestService{
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
