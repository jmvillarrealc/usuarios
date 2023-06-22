# THIS IS THE ONLY ONE LINE TO UPDATE ######
BASE=/home/ubuntu/development/software/eclipse/Prueba/learn-spring-boot-1.1/src/main/resources/db/
# ##########################################


# Following is invariant for any machine or environment
mkdir -p $BASE/data
mkdir -p $BASE/scripts


DATABASE=$BASE/data
SCRIPTS=$BASE/scripts
ROOT_PASS=garellano

docker stop database
docker rm database

docker run -d \
--name database \
--restart unless-stopped \
-p 3306:3306 \
-v $DATABASE:/var/lib/mysql \
-v $SCRIPTS:/scripts \
-e MYSQL_ROOT_PASSWORD=$ROOT_PASS \
mariadb
