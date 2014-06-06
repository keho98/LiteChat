
public class BasicChatProtocol implements ChatProtocol{

	@Override
	public String processClientInput(String clientInput) {
		return clientInput;
	}

	@Override
	public String processServerInput(String serverInput) {
		return serverInput;
	}

}
