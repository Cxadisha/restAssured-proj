package Services;

import Request.Body;
import Request.Envelope;
import Request.GetListByName;

public class RequestService {

    public static Envelope getListByName(String name) {
        return new Envelope(new Envelope.Header(), new Body(new GetListByName(name)));
    }
}
