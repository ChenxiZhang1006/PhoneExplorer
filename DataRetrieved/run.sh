cd bin/
jar -cvmf Config.mf ../writeCognif.jar writeConfigFile.class
jar -cvmf getStudiesFromDbGaPWebsiteManifest.mf ../getStudiesFromDbGaPWebsite.jar dbConnect.class getStudiesFromDbGaPWebsite.class htmlParse.class HttpGetMethod.class HttpPostMethod.class
jar -cvmf getVariablesFromDbGaPFTPManifest.mf ../getVariablesFromDbGaPFTP.jar dbConnect.class ftpClientMethod.class ftpFileList.class getVariablesFromDbGaPFTP.class
jar -cvmf createTables.mf ../creatTables.jar createTables.class dbConnect.class
cd ..
java -jar creatTables.jar
java -jar getStudiesFromDbGaPWebsite.jar
java -jar getVariablesFromDbGaPFTP.jar -d -p -l
rm -rf Study/