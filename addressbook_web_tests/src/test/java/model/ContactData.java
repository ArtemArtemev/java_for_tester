package model;

public record ContactData(String id, String firstname, String middlename, String lastname, String nickname, String title, String company, String address,
                          String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String photo) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withfirstname(String firstname) {
        return new ContactData(this.id, firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname,this.middlename, lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withNickname(String nickname) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withTitle(String title) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, work, this.fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withFax(String fax) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, fax, this.email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, email, this.email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, email2, this.email3, this.homepage, this.photo);
    }
    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, email3, this.homepage, this.photo);
    }
    public ContactData withHomepage(String homepage) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, email3, homepage, this.photo);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname,this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, email3, homepage, photo);
    }
}