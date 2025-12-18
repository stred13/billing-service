CREATE TABLE SERVICE_MODEL (
                               BILLABLE BOOLEAN,
                               ID UUID NOT NULL,
                               COST_CENTER VARCHAR(255),
                               LEGAL_ENTITY VARCHAR(255),
                               PLACEMENT VARCHAR(255) NOT NULL,
                               SERVICE_NAME VARCHAR(255),
                               CONSTRAINT SERVICE_MODEL_PKEY PRIMARY KEY (ID, PLACEMENT)
) PARTITION BY LIST(PLACEMENT);

CREATE TABLE placement_apac PARTITION OF SERVICE_MODEL
    FOR VALUES IN ('APAC');

CREATE TABLE placement_europe PARTITION OF SERVICE_MODEL
    FOR VALUES IN ('EUROPE');

CREATE TABLE placement_america PARTITION OF SERVICE_MODEL
    FOR VALUES IN ('AMERICA');