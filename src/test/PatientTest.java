package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.dentalofficemanager.common.exceptions.InvalidSocialSecurityNumberException;
import br.com.dentalofficemanager.patient.model.SocialSecurityTypeEnum;
import br.com.dentalofficemanager.patient.utils.PatientValidationUtil;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-context.xml" )
@TestExecutionListeners({ ServletTestExecutionListener.class, DependencyInjectionTestExecutionListener.class })
public class PatientTest {
	
	@Test
	public void assertValidSsnRGType() throws InvalidSocialSecurityNumberException {
		SocialSecurityTypeEnum ssnType = SocialSecurityTypeEnum.RG;
		String ssnId = "31.336.277-4";
		assertTrue(PatientValidationUtil.ssnValidator(ssnId, ssnType));
	}
	
	@Test
	public void assertValidSsnCPFType() throws InvalidSocialSecurityNumberException {
		SocialSecurityTypeEnum ssnType = SocialSecurityTypeEnum.CPF;
		String ssnId = "737.481.910-22";
		assertTrue(PatientValidationUtil.ssnValidator(ssnId, ssnType));
	}
	
	@Test
	public void assertValidSsnCNPJType() throws InvalidSocialSecurityNumberException {
		SocialSecurityTypeEnum ssnType = SocialSecurityTypeEnum.CNPJ;
		String ssnId = "43.498.556/0001-62";
		assertTrue(PatientValidationUtil.ssnValidator(ssnId, ssnType));
	}

}
