package me.kevin.base;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2017/1/19.
 */
public class PlatformsTest {

    @Test
    public void platformsTest() {
        if (Platforms.IS_WINDOWS) {
            assertThat(Platforms.FILE_PATH_SEPARTOR).isEqualTo("\\");
            assertThat(Platforms.FILE_PATH_SEPARTOR_CHAR).isEqualTo('\\');
        }else{
            assertThat(Platforms.FILE_PATH_SEPARTOR).isEqualTo("/");
            assertThat(Platforms.FILE_PATH_SEPARTOR_CHAR).isEqualTo('/');
        }

        System.out.println("OS_NAME:" + Platforms.OS_NAME);
        System.out.println("OS_VERSION:" + Platforms.OS_VERSION);
        System.out.println("OS_ARCH:" + Platforms.OS_ARCH);
        System.out.println("JAVA_SPECIFICATION_VERSION:" + Platforms.JAVA_SPECIFICATION_VERSION);
        System.out.println("JAVA_VERSION:" + Platforms.JAVA_VERSION);
        System.out.println("JAVA_HOME:" + Platforms.JAVA_HOME);
        System.out.println("TMP_DIR:" + Platforms.TMP_DIR);
        System.out.println("WORKING_DIR:" + Platforms.WORKING_DIR);

        if(Platforms.IS_JAVA6){
            assertThat(Platforms.IS_ATLEASET_JAVA6).isTrue();
            assertThat(Platforms.IS_ATLEASET_JAVA7).isFalse();
            assertThat(Platforms.IS_ATLEASET_JAVA8).isFalse();
        }

        if (Platforms.IS_JAVA7) {
            assertThat(Platforms.IS_ATLEASET_JAVA6).isTrue();
            assertThat(Platforms.IS_ATLEASET_JAVA7).isTrue();
            assertThat(Platforms.IS_ATLEASET_JAVA8).isFalse();
        }

        if (Platforms.IS_JAVA8) {
            assertThat(Platforms.IS_ATLEASET_JAVA6).isTrue();
            assertThat(Platforms.IS_ATLEASET_JAVA7).isTrue();
            assertThat(Platforms.IS_ATLEASET_JAVA8).isTrue();
        }
    }
}
