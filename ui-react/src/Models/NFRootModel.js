import { observable, observer, computed, action } from "mobx";

class NFRootModel {

  @observable host;
  @observable host_dev = "http://127.0.0.1:5000";
  //@observable host_dev = "http://leetframe.com:5000";
  @observable host_pro = "http://leetframe.com:5000";


  @observable isLoggedIn = false;
  @observable userID;
  @observable jwt;
  @observable contentType = 0;
  @observable isLoading = false;
  @observable isAdminMode = false;

  @action
  clearAllData() {
    this.isLoggedIn = false;
    this.userID = "";
    this.jwt = "";
    this.contentType = 0;
    this.isLoading = false;
  
  }

  @action
  setProdEvn(b) {
    if (b)
    {
      this.host = this.host_pro;
    }
    else
    {
      this.host = this.host_dev;
    }
  }

  @action
  setLoginState(isLogin) {
    this.isLoggedIn =isLogin;
  }

}
export default NFRootModel;