package iqmsoft.api.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface OnlyRemote {
  String getMessage();
}
