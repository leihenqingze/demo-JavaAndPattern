package thirdpart.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Decorator implements Component {

    private Component component;

    /**
     * 商业方法，委派给构件
     */
    @Override
    public void sampleOperation() {
        component.sampleOperation();
    }
}
