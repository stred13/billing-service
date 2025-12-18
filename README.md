# Billing-service
Second part of final project of data intensive course in Master degree of Lut university

ERD Diagram for database
<img width="2061" height="1855" alt="erd" src="https://github.com/user-attachments/assets/597daecb-cafe-46bf-88e0-adbcc6658cf9" />

Docker compose file for DB setup:
https://github.com/stred13/billing-service/blob/master/billingservice/compose.yaml

Entity models represent for table in database:
https://github.com/stred13/billing-service/tree/master/billingservice/src/main/java/com/lut/billingservice/model

Script to create Partition table
https://github.com/stred13/billing-service/blob/master/billingservice/src/main/resources/db/changelog/partition.sql
</br>
<img width="233" height="156" alt="image" src="https://github.com/user-attachments/assets/23cd93e7-78ef-4b18-bd83-27e6b3cd0e9f" />

Setup Replication:
1. Create replicator user for replica accessing publisher
   </br>
   <img width="530" height="415" alt="image" src="https://github.com/user-attachments/assets/191ec16d-cdc0-49d7-92b1-8b8fbc315b15" />
	</br>
   <img width="700" height="431" alt="image" src="https://github.com/user-attachments/assets/9bc37743-4742-4a3c-80da-f2d1afb8dde4" />
   </br>
   </br>

3. create publications
	</br>
	create publication config
	</br>
   <img width="443" height="124" alt="image" src="https://github.com/user-attachments/assets/d123ed74-c966-490d-abfe-2e3cda15da4b" />
</br>
</br>
   select table and corresponding column for replication
   </br>
   <img width="542" height="417" alt="image" src="https://github.com/user-attachments/assets/d91ae564-4351-4e4c-aac4-5156de92037f" />
</br>
4. create subscribers
   create subscriber config
   </br>
   <img width="457" height="150" alt="image" src="https://github.com/user-attachments/assets/8a7d0187-70d5-450f-b3a7-db0d2b984375" />
   </br>
   </br>
   Fill in the publisher information and the replicator user to connect to the publisher.
</br>
   <img width="527" height="419" alt="image" src="https://github.com/user-attachments/assets/6c72efec-62e8-41ca-87bb-3ea3a49a4bf7" />

