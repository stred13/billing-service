# Billing-service
Second part of final project of data intensive course in Master degree of Lut university

ERD Diagram for database
<img width="2061" height="1855" alt="erd" src="https://github.com/user-attachments/assets/597daecb-cafe-46bf-88e0-adbcc6658cf9" />

Docker compose file for DB setup:
https://github.com/stred13/billing-service/blob/master/billingservice/compose.yaml

Entity models represent for table in database:
https://github.com/stred13/billing-service/tree/master/billingservice/src/main/java/com/lut/billingservice/model

Script to create Partition table
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

<img width="233" height="156" alt="image" src="https://github.com/user-attachments/assets/23cd93e7-78ef-4b18-bd83-27e6b3cd0e9f" />
