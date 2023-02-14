@XmlSchema(elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "soapenv",namespaceURI = "http://schemas.xmlsoap.org/soap/envelope/"),
                @XmlNs(prefix = "tem",namespaceURI = "http://tempuri.org")
        })

package Request;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;