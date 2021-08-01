package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make{
    request{
        method(GET())
        url("/cats/Toby")
    }
    response{
        status(OK())
        headers{
            contentType(applicationJson())
        }
        body([name:"Toby"])
    }
}

