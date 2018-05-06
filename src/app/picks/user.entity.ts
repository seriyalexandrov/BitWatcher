export class UserEntity {
  name: string;
  lastname: string;
  userId: number;
  login: string;
  password: string;
  email: string;

  UserEntity() {
    this.userId = -1;
  };
}
