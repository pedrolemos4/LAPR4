package base.daemon.motor.protocol;

import eapli.framework.csv.CsvRecord;

public abstract class BaseErrorRequest extends AplicacoesRequest {

    private final String errorDescription;

    protected BaseErrorRequest(final String request, final String errorDescription) {
        super(null, request);
        this.errorDescription = errorDescription;
    }

    protected BaseErrorRequest(final String request) {
        super(null, request);
        this.errorDescription = null;
    }

    @Override
    public byte[] execute() {
        // nothing to do, just build the response
        return buildResponse().getBytes();
    }

    protected String buildResponse() {
        final Object[] fields = {
                messageType(),
                request,
                errorDescription
        };
        final boolean[] mask = { false, true, true };
        return CsvRecord.valueOf(fields, mask).toString() + "\n";
    }

    protected abstract String messageType();
}
