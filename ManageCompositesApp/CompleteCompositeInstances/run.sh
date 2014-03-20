# This script should be in the same directory as the ManageComposite.jar file

# Modify the FMW_HOME to point to local location of oracle fmw
FMW_HOME=/oracle/fmwhome

CLASSPATH=./ManageComposites.jar
CLASSPATH=$CLASSPATH:$FMW_HOME/oracle_common/soa/modules/oracle.soa.mgmt_11.1.1/soa-infra-mgmt.jar
CLASSPATH=$CLASSPATH:$FMW_HOME/oracle_common/webservices/wsclient_extended.jar
CLASSPATH=$CLASSPATH:$FMW_HOME/oracle_common/modules/oracle.fabriccommon_11.1.1/fabric-common.jar
CLASSPATH=$CLASSPATH:$FMW_HOME/oracle_common/modules/wlthint3client.jar

# Check the input parameters on the last line
# p1 - listFaulted or removeFaulted
# p2 - SOA partition name
# p3 - SOA Server host name
# p4 - SOA Server port
# p5 - SOA Admin username
# p6 - SOA Admin password
java -cp $CLASSPATH com.managesoa.ManageComposites interactive default localhost 7001 weblogic welcome1
~                          
