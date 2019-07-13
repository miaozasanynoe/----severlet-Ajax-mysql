package util;

import java.io.File;
import java.io.InputStream;

import com.qcloud.*;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

public class tecent_upload {
	COSClient cosClient;
	public void conn() {
		// 1 ��ʼ���û������Ϣ��secretId, secretKey����
		String secretId = "AKIDGLEqCKm26qLaYOycuELDqDPSXqFglITY";
		String secretKey = "DOcnoeQN7orlZzVbYZRn4HMJDiaIyOYT";
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		// 2 ���� bucket ������, COS ����ļ������� https://cloud.tencent.com/document/product/436/6224
		// clientConfig �а��������� region, https(Ĭ�� http), ��ʱ, ����� set ����, ʹ�ÿɲμ�Դ����߳������� Java SDK ���֡�
		Region region = new Region("ap-chengdu");
		ClientConfig clientConfig = new ClientConfig(region);
		// 3 ���� cos �ͻ��ˡ�
		cosClient = new COSClient(cred, clientConfig);
	}
	public void upload_images(String bucketName, String key, InputStream input) {
		try {
		    // ָ��Ҫ�ϴ����ļ�
			ObjectMetadata metadata = new ObjectMetadata();
			// ��������������Ϊ500
			metadata.setContentLength(500);  
			// ���� Content type, Ĭ���� application/octet-stream
			metadata.setContentType("application/octet-stream");
			 cosClient.putObject(bucketName, key, input, metadata);
		 //   File localFile = new File("exampleobject");
		    // ָ��Ҫ�ϴ����Ĵ洢Ͱ
//		    String bucketName = "examplebucket-1250000000";
//		    // ָ��Ҫ�ϴ��� COS �϶����
//		    String key = "exampleobject";
//		    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
//		    PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
		} catch (CosServiceException serverException) {
		    serverException.printStackTrace();
		} catch (CosClientException clientException) {
		    clientException.printStackTrace();
		}
	}
	public void upload_images(String key, File file) {
		String bucketName = "test-1258897694";
		// ����1 �����ļ��ϴ�
		File localFile = file;
		String key1 = "exampleobject";
		PutObjectResult putObjectResult = cosClient.putObject(bucketName, key1, localFile);
		String etag = putObjectResult.getETag();  // ��ȡ�ļ��� etag
		System.out.print(etag);
	}
}
