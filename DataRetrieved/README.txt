/********************
Tables
*********************/
Orginal four tables:
1.dbgap_studies_org(Study_Accession_ID    Study_URL    Study_Name    Embargo_Release    Participants    Type_Of_Study    Platform    Description    Orig_Study_URL)
2.dbgap_variables_org(Variable_ID    Variable_Name    Variable_Description    Variable_Type    Varibale_Units    Logical_Minimum    Logical_Maximum    Variable_Comment)
3.Variable_Value(Variable_ID    Variable_Code    Variable_Code_Description)
4. Diseases (dbGaP_Study_ID    Vocabulary    Disease)

Two new generated tables:
1.dbgap_studies(dbgap_study_id, dbgap_study_name, participants, study_type, platform, genetic_type, race, sex, min_age, max_age, description, diseases, study_url)
2.dbgap_variables(variable_id, variable_name, study_id, study_name, url_suffix, description, study_url, variable_url, study_href, variable_href)

/********************
instructions
*********************/
1.cd bin/
change to directory bin/

2. jar -cvmf Config.mf ../writeCognif.jar writeConfigFile.class
jar writeCognif.jar

3.jar -cvmf getStudiesFromDbGaPWebsiteManifest.mf ../getStudiesFromDbGaPWebsite.jar dbConnect.class getStudiesFromDbGaPWebsite.class htmlParse.class HttpGetMethod.class HttpPostMethod.class
jar getStudiesFromDbGaPWebsite.jar

4.jar -cvmf getVariablesFromDbGaPFTPManifest.mf ../getVariablesFromDbGaPFTP.jar dbConnect.class ftpClientMethod.class ftpFileList.class getVariablesFromDbGaPFTP.class
jar getVariablesFromDbGaPFTP.jar

5.jar -cvmf createTables.mf ../creatTables.jar createTables.class dbConnect.class
jar creatTables.jar


6. cd ..
back to parent directory

7.java -jar config.jar
write a configuration file config/config.properties

8.java -jar getStudiesFromDbGaPWebsite.jar -k
get studies values from DbGap website for table dbgap_studies
with -k, means insert data into dbgap_studies_org

9. java -jar getVariablesFromDbGaPFTP.jar -d -p -l -k -s -v
get variables from DbGap FTP for table dbgap_variables
-d download .xml files into local directory Study/
-p parse .xml files from local directory Study/. if do NOT download these files(-d), -p is meaningless
-l load DataBase, and insert data into table. if do NOT download files(-d) and parse them(-p), -l is meaningless
-k insert data into table dbgap_variables_org. -k should appear at same time with -k from the second step
-s insert data into table Diseases
-v insert data into table Variable_Value


10. rm -rf Study/
delete the directory Study/ and its files, without asking.

/********************
additonal information
*********************/
1. for all data, use " " " replace " ' " 
2. use " | " to separate multi-value for one row
3. when run the program will encouter Duplicate Exception, just ignore them, it won't break the whole program