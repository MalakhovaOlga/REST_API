package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/getSAPLogin")
//    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
    public Accounts getSAPLogin(@RequestParam(value="userAccount", required=true) String userAccount) {
        String SAPLogin = DataPoolProcessing.getInstance().getSAPLogin(userAccount);
        return new Accounts(userAccount,SAPLogin);
    }
}